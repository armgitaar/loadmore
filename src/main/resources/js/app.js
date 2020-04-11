import Vue from 'vue'
import axios from 'axios'

window.axios = axios
window.axios.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest'

Vue.component('welcome', require('./components/Welcome').default)
Vue.component('show-more', require('./components/ShowMore').default)

new Vue({
    el: '#app'
})
