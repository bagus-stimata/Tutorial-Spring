package com.example.springbootsecurity2mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingExtended {

    /*
    Ketika di auto wire maka akan berlaku untuk semua scoop aplikasi
    Testing 
    Bahkan jika dibuka pada browser dan komputer lain: maka akan bernilai sama
    Jadi semacam Variable Global
    */
    @Autowired(required = false) //required: tidak terlalu berguna
    @Qualifier("fooMahasiswa") //Qualifier: untuk memastikan saja
    private Mahasiswa mhs;
 
    @GetMapping("/greeting_view")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="Mas Kirun") String name, Model uiModel) {
        name = "Mas Arif Rahman Hakim";
        uiModel.addAttribute("name", name);
        int umur = 21;
        uiModel.addAttribute("umur", umur);
        
        //Ini dilakukan di greeting_init: maka sekalai diisi nilai di greeting init maka akan berlaku di semua scope aplikasi
        // mahasiswa.setNama("Bagus Winarno");
        // mahasiswa.setAlamat("Dsn Wangkal Ds. Tengger Lor Kec. Kunjang Keb Kediri");
        uiModel.addAttribute("mahasiswa", mhs);

        //Menggunakan template greeting yang sama
		return "template_greeting";
    }
    

}