import './assets/main.css'

import { createApp } from 'vue'
import PrimeVue from 'primevue/config'
import Aura from '@primevue/themes/aura'
import Lara from '@primevue/themes/lara'
import App from './App.vue'
import router from './router'


import RadioButton from 'primevue/radiobutton';
import RadioButtonGroup from 'primevue/radiobuttongroup';
import Slider from 'primevue/slider'
import SelectButton from 'primevue/selectbutton';
import InputMask from 'primevue/inputmask';
import Textarea from 'primevue/textarea';
import Button from 'primevue/button';
import Editor from 'primevue/editor';
import Listbox from 'primevue/listbox'

const app = createApp(App)

app.use(PrimeVue, {
  theme: {
    preset: Lara,
  },
})

app.use(router)

app.component('Slider', Slider)
app.component('RadioButton', RadioButton)
app.component('RadioButtonGroup', RadioButtonGroup)
app.component('SelectButton', SelectButton)
app.component('InputMask', InputMask)
app.component('Textarea', Textarea)
app.component('Button', Button)
app.component('Editor', Editor)
app.component('Listbox', Listbox)

app.mount('#app')
