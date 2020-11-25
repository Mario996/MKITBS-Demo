import Vue from 'vue'
import Vuetify from 'vuetify'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import * as VueGoogleMaps from "vue2-google-maps";

Vue.config.productionTip = false

Vue.use(Vuetify);

Vue.use(VueGoogleMaps, {
  load: {
    key: "",
    libraries: "places" // necessary for places input
  }
});

new Vue({
  vuetify,
  render: h => h(App)
}).$mount('#app')
