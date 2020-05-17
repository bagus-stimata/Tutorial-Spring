import { PolymerElement } from '@polymer/polymer/polymer-element.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-grid/all-imports.js';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/vaadin-vertical-layout.js';
import '@vaadin/vaadin-lumo-styles/all-imports.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';


import mainCSS from "../../../styles/main.css";
let mainCSSLiteral = html(mainCSS);

class CardListView extends PolymerElement {
  static get template() {
    return html`

        <style include="shared-styles lumo-badge lumo-typography">
          :host {
            display: block;
            height: 100%;
          }

          vaadin-grid {
            height: 100%;
            line-height: var(--lumo-line-height-m);
          }

          vaadin-grid,
          vaadin-grid-cell-content {
            background-color: var(--lumo-contrast-10pct);
          }          
          .card {
            background-color: var(--lumo-base-color);
            border-radius: var(--lumo-border-radius);
            box-shadow: var(--lumo-box-shadow-xs);
            padding: calc(var(--lumo-space-s) * 1.5) var(--lumo-space-m);
          }

          img {
            border-radius: 50%;
            flex-shrink: 0;
            height: var(--lumo-size-m);
            width: var(--lumo-size-m);
          }

          .header {
            align-items: baseline;
          }

          .name {
            font-size: var(--lumo-font-size-s);
            font-weight: bold;
          }

          .date {
            color: var(--lumo-tertiary-text-color);
            font-size: var(--lumo-font-size-xs);
          }

          .post {
            color: var(--lumo-secondary-text-color);
            font-size: var(--lumo-font-size-s);
            margin-bottom: var(--lumo-space-s);
            white-space: normal;
          }

          .actions {
            align-items: center;
          }

          iron-icon {
            color: var(--lumo-tertiary-text-color);
            height: calc(var(--lumo-icon-size-s) * 0.8);
            width: calc(var(--lumo-icon-size-s) * 0.8);
          }

          .likes,
          .comments,
          .shares {
            color: var(--lumo-tertiary-text-color);
            font-size: var(--lumo-font-size-xs);
            margin-right: var(--lumo-space-l);
          }
        </style>

        <style>${mainCSSLiteral}</style>

        // <link  rel="stylesheet" th:href="@{~/css/main.css}" />
        // <!-- <script th:src="@{/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js}"></script> -->
        // <script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
        // <!-- <link rel="stylesheet" th:href="@{/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css} "/> -->
        // <link rel="stylesheet" th:href="@{/webjars/bootstrap/css/bootstrap.min.css} "/>
        // <link rel="stylesheet" th:href="@{/webjars/bootstrap/css/bootstrap-responsive.css} "/>
     
        // <link th:rel="stylesheet" th:href="@{/webjars/font-awesome/css/all.css} "/>
          
      <h1 class="ada-deh" > Hello bos </h1>
      <div class="continer row h-100 justify-content-center align-items-center">
        <div class="jumbotron shadow-sm" style="width: 50em; background-color:rgb(124, 104, 177)">
            <h1 class="display-4">PAGE ADMIN</h1>
            <p class="lead">This is the home page of our web application. Anyone can access it, even if they have not signed in.</p>
            <hr class="my-4">
            <p>Using this example, you will become more familiar with Spring Security concepts:)</p>
            <p class="lead">
                <a class="btn btn-primary btn-lg" href="https://spring.io/projects/spring-security" role="button">Learn more about Spring Security</a>
            </p>
        </div>
      </div>


        <vaadin-grid id="grid" theme="no-border no-row-borders" items="[[items]]">
          <vaadin-grid-column>
            <template>
              <vaadin-horizontal-layout theme="spacing-s" class="card">
                <img src="[[item.image]]" />
                <vaadin-vertical-layout>
                  <vaadin-horizontal-layout theme="spacing-s" class="header">
                    <span class="name">[[item.name]]</span>
                    <span class="date">[[item.date]]</span>
                  </vaadin-horizontal-layout>
                  <span class="post">[[item.post]]</span>
                  <vaadin-horizontal-layout theme="spacing-s" class="actions">
                    <iron-icon icon="vaadin:heart"></iron-icon>
                    <span class="likes">[[item.likes]]</span>
                    <iron-icon icon="vaadin:comment"></iron-icon>
                    <span class="comments">[[item.comments]]</span>
                    <iron-icon icon="vaadin:connect"></iron-icon>
                    <span class="shares">[[item.shares]]</span>
                  </vaadin-horizontal-layout>
                </vaadin-vertical-layout>
              </vaadin-horizontal-layout>
            </template>
          </vaadin-grid-column>
        </vaadin-grid>


    `;
  }

  static get is() {
    return 'card-list-view';
  }

  static get properties() {
    return {
      // Declare your properties here.
    };
  }
}

customElements.define(CardListView.is, CardListView);
