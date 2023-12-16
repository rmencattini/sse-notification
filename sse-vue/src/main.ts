import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import KeyCloakService from "./services/keycloak-service.ts";

KeyCloakService.CallLogin(() => createApp(App).mount('#app'))
