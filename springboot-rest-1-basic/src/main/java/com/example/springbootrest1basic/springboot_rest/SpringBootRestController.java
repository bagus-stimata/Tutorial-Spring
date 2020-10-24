package com.example.springbootrest1basic.springboot_rest;

import com.example.springbootrest1basic.model.DataFactory;
import com.example.springbootrest1basic.model.DataRepository;
import com.example.springbootrest1basic.model.Employee;

import com.example.springbootrest1basic.model.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SpringBootRestController {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootRestController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private DataRepository repository;

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET,
    produces = { "application/json" })
    public Employee getEmployee() {

        Employee emp = new Employee();
        emp.setName("Bagus Winarno Jos Bos");
        emp.setDesignation("manager");
        emp.setId(1);
        emp.setSalary(3000);

        return emp;
    }

    @RequestMapping(value = "/getEmployeeParam", method = RequestMethod.GET,
            produces = { "application/json" })
    public Employee getEmployeeParam(@RequestParam("id") int id) {

        Employee emp = new Employee();
        emp = repository.mapEmployee.get(id);
        return emp;
    }

    @RequestMapping(value = "/getEmployeePath/{id}", method = RequestMethod.GET,
            produces = { "application/json" })
    public Employee getEmployeePath(@PathVariable("id") int id) {
        Employee emp = new Employee();
        emp = repository.mapEmployee.get(id);
        return emp;
    }

    @RequestMapping(value = "/getListEmployee", method = RequestMethod.GET,
            produces = { "application/json" })
    public Collection<Employee> getListEmployee() {
        return repository.mapEmployee.values();
    }
    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST,
    produces = {"application/json"})
    public Employee createEmployee(@RequestBody Employee employee){
        repository.mapEmployee.put(employee.getId(), employee);
        return employee;
    }
    @RequestMapping(value = "/putEmployee", method = RequestMethod.PUT,
            produces = {"application/json"})
    public Employee putEmployee(@RequestParam("id") int id,  @RequestBody Employee employee){
        repository.mapEmployee.put(id, employee);
        return employee;
    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE,
            produces = {"application/json"})
    public Employee deleteEmployee(@PathVariable int id){
        repository.mapEmployee.get(id);
        repository.mapEmployee.remove(id);
        return repository.mapEmployee.get(id);
    }

    /**
     * SETELAH UPLOAD MEMBERIKAN NILAI BALIK BERUPA FILE TERSEBUT
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        System.out.println("Hello pak ade londho: " + fileName);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse response = new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        if (response==null) {
            System.out.println("RESPONSE NYA NULL BOS");
        }else {
            System.out.println("Ada Isinya kok: " + response.getFileDownloadUri() + " >> " + response.getFileName());
        }
        return response;
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}