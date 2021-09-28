import '@vaadin/vaadin-material-styles/color.js';
import '@vaadin/vaadin-material-styles/mixins/menu-overlay.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';

const $_documentContainer = html`<dom-module id="vcf-v8-material-combo-box-overlay" theme-for="vcf-v8-combo-box-overlay">
  <template>
    <style include="material-menu-overlay">
      :host {
        /* TODO using a legacy mixin (unsupported) */
        --iron-list-items-container: {
          border-width: 8px 0;
          border-style: solid;
          border-color: transparent;
        };
      }

      [part="overlay"] {
        position: relative;
        overflow: visible;
        border-top-left-radius: 0;
        border-top-right-radius: 0;
      }

      [part="content"] {
        padding: 0;
      }

      :host([loading]) [part="loader"] {
        height: 2px;
        position: absolute;
        z-index: 1;
        top: -2px;
        left: 0;
        right: 0;
        background:
          var(--material-background-color) linear-gradient(
            90deg,
            transparent 0%,
            transparent 20%,
            var(--material-primary-color) 20%,
            var(--material-primary-color) 40%,
            transparent 40%,
            transparent 60%,
            var(--material-primary-color) 60%,
            var(--material-primary-color) 80%,
            transparent 80%,
            transparent 100%
          ) 0 0 / 400% 100% repeat-x;
        opacity: 0;
        animation:
          3s linear infinite material-combo-box-loader-progress,
          .3s .1s both material-combo-box-loader-fade-in;
      }

      [part="loader"]::before {
        content: '';
        display: block;
        height: 100%;
        opacity: 0.16;
        background: var(--material-primary-color);
      }

      @keyframes material-combo-box-loader-fade-in {
        0% {
          opacity: 0;
        }

        100% {
          opacity: 1;
        }
      }

      @keyframes material-combo-box-loader-progress {
        0% {
          background-position: 0 0;
          background-size: 300% 100%;
        }

        33% {
          background-position: -100% 0;
          background-size: 400% 100%;
        }

        67% {
          background-position: -200% 0;
          background-size: 250% 100%;
        }

        100% {
          background-position: -300% 0;
          background-size: 300% 100%;
        }
      }

      /* RTL specific styles */

      @keyframes material-combo-box-loader-progress-rtl {
        0% {
          background-position: 100% 0;
          background-size: 300% 100%;
        }

        33% {
          background-position: 200% 0;
          background-size: 400% 100%;
        }

        67% {
          background-position: 300% 0;
          background-size: 250% 100%;
        }

        100% {
          background-position: 400% 0;
          background-size: 300% 100%;
        }
      }

      :host([loading][dir="rtl"]) [part="loader"] {
        animation:
          3s linear infinite material-combo-box-loader-progress-rtl,
          .3s .1s both material-combo-box-loader-fade-in;
      }
    </style>
  </template>
</dom-module>`;

document.head.appendChild($_documentContainer.content);
