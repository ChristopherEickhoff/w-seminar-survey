<script setup lang="ts">
import { ref } from 'vue'
import SelectButton from 'primevue/selectbutton'
import InputMask from 'primevue/inputmask'
import Slider from 'primevue/slider'
import Textarea from 'primevue/textarea';
import Button from 'primevue/button';


const age = ref('30-44') 
const age_options = ['unter 18', '18-29', '30-44', '45-59', '60+']

const sex = ref('männlich')
const sex_options = ['männlich', 'weiblich', 'divers', 'keine Angabe']

const plz = ref('')
const plz_mask = '99999'

const residential_area = ref('Stadt')
const residential_area_options = ['Stadt', "Landkreis"]

const school_education = ref('Abitur')
const school_education_options = ['kein Abschluss', 'Hauptschulabschluss', 'Realschulabschluss', 'Abitur', 'keine Angabe']

const monthly_income = ref("beneath 1.500€")
const monthly_income_options = ['beneath 1.500€', '1.500€-2.999€', '3.000€-4.999€', '5.000€-6.999€', 'über 7.000€']

const public_transportation_availability = ref("ausreichend")
const public_transportation_availability_options = ['sehr gut', 'gut', 'ausreichend', 'schlecht', 'sehr schlecht']

const main_transportation_means = ref("Auto (Verbrenner)")
const main_transportation_means_options = ['Auto (Verbrenner)', 'Auto (Elektro/Hybrid)', 'Fahrrad', 'Öffentliche Verkehrsmittel', 'zu Fuß']

const public_transportation_usage = ref("mehrmals pro Woche")
const public_transportation_usage_options = ['täglich', 'mehrmals pro Woche', 'einmal pro Woche', 'seltener', 'nie']

const regional_and_seasonal_food = ref(3)

const vegetarian_or_vegan_diet = ref(3)

const avoid_flying = ref(3)

const use_secondhand_or_durable_products = ref(3)

const save_energy_at_home = ref(3)

const separate_waste = ref(3)

const shop_plastic_free = ref(3)

const additional_information = ref('')

async function submit_survey() {
  const payload = {
    age: age.value,
    sex: sex.value,
    plz: plz.value,
    residential_area: residential_area.value,
    school_education: school_education.value,
    monthly_income: monthly_income.value,
    public_transportation_availability: public_transportation_availability.value,
    main_transportation_means: main_transportation_means.value,
    public_transportation_usage: public_transportation_usage.value,
    regional_and_seasonal_food: regional_and_seasonal_food.value,
    vegetarian_or_vegan_diet: vegetarian_or_vegan_diet.value,
    avoid_flying: avoid_flying.value,
    use_secondhand_or_durable_products: use_secondhand_or_durable_products.value,
    save_energy_at_home: save_energy_at_home.value,
    separate_waste: separate_waste.value,
    shop_plastic_free: shop_plastic_free.value,
    additional_information: additional_information.value
  };

  if (plz.value.length != 5) {
    alert('Bitte gib eine valide PLZ an!')
    return;
  }

  await fetch('http://localhost:8081/submit', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(payload)
  });

  window.location.replace("/thankyou")
}

</script>

<template>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <h1>W Seminar Umfrage</h1>

  <br>
  <div class="general-information">
    <h2>Allgemeine Angaben</h2>

    <div class="alter-select">
      <label for="age"><h3>Bitte wähle dein Alter aus</h3></label>
      <SelectButton v-model="age" :options="age_options" />
      <br>
    </div>

    <div class="sex-select">
      <label for="sex"><h3>Bitte wähle dein Geschlecht aus</h3></label>
      <SelectButton v-model="sex" :options="sex_options" />
      <br>
    </div>

    <div class="plz-input">
      <label for="plz"><h3>Bitte gib deine Postleitzahl ein</h3></label>
      <InputMask v-model="plz" :mask="plz_mask" placeholder="12345" />
      <br>
    </div>  

    <div class="residential_area-select">
      <label for="residential_area"><h3>Bitte wähle deinen Wohnort aus</h3></label>
      <SelectButton v-model="residential_area" :options="residential_area_options" />
      <br>
    </div>
  </div>

  <br>
  <div class="socioeconomic_characteristics">
    <h2>Sozioökonomische Merkmale</h2>
    <div class="school_education-select">
      <label for="school_education"><h3>Bitte wähle deinen höchsten Schulabschluss aus</h3></label>
      <SelectButton v-model="school_education" :options="school_education_options" />
      <br>
    </div>

    <div class="monthly_income-select">
      <label for="monthly_income"><h3>Bitte wähle dein monatliches Nettoeinkommen aus</h3></label>
      <SelectButton v-model="monthly_income" :options="monthly_income_options" />
      <br>
    </div>
  </div>


  <br>
  <div class="mobility_and_public_transportation">
    <h2>Mobilität und ÖPNV</h2>

    <div class="public_transportation_availability-select">
      <label for="public_transportation_availability"><h3>Wie würdest du die Verfügbarkeit von öffentlichen Verkehrsmitteln in deinem Wohnort beschreiben?</h3></label>
      <SelectButton v-model="public_transportation_availability" :options="public_transportation_availability_options" />
      <br>
    </div>

    <div class="main_transportation_means-select">
      <label for="main_transportation_means"><h3>Was ist dein Hauptverkehrsmittel?</h3></label>
      <SelectButton v-model="main_transportation_means" :options="main_transportation_means_options" />
      <br>
    </div>

    <div class="public_transportation_usage-select">
      <label for="public_transportation_usage"><h3>Wie oft nutzt du öffentliche Verkehrsmittel?</h3></label>
      <SelectButton v-model="public_transportation_usage" :options="public_transportation_usage_options" />
      <br>
    </div>
  </div>


  <br>
  <div class="climate-conscious-behavior">
    <h2>Klimabewusstes Verhalten (Skala: 1 = nie, 5 = immer)</h2>
    
    <div class="regional_and_seasonal_food">
      <label for="regional_and_seasonal_food"><h3>Ich kaufe regionale und saisonale Lebensmittel: {{ regional_and_seasonal_food }}</h3></label>
      <Slider v-model="regional_and_seasonal_food" :min="1" :max="5" :step="1" />
      <br>
    </div>

    <div class="vegetarian_or_vegan_diet">
      <label for="vegetarian_or_vegan_diet"><h3>Ich ernähre mich vegetarisch oder vegan: {{ vegetarian_or_vegan_diet }}</h3></label>
      <Slider v-model="vegetarian_or_vegan_diet" :min="1" :max="5" :step="1" />
      <br>
    </div>
    
    <div class="avoid_flying">
      <label for="avoid_flying"><h3>Ich vermeide Flugreisen: {{ avoid_flying }}</h3></label>
      <Slider v-model="avoid_flying" :min="1" :max="5" :step="1" />
      <br>
    </div>
    
    <div class="use_secondhand_or_durable_products">
      <label for="use_secondhand_or_durable_products"><h3>Ich kaufe Secondhand- oder langlebige Produkte: {{ use_secondhand_or_durable_products }}</h3></label>
      <Slider v-model="use_secondhand_or_durable_products" :min="1" :max="5" :step="1" />
      <br>
    </div>

    <div class="save_energy_at_home">
      <label for="save_energy_at_home"><h3>Ich spare Energie im Haushalt (z.B. durch LED-Lampen, Standby vermeiden): {{ save_energy_at_home }}</h3></label>
      <Slider v-model="save_energy_at_home" :min="1" :max="5" :step="1" />
      <br>
    </div>

    <div class="separate_waste">
      <label for="separate_waste"><h3>Ich trenne meinen Müll: {{ separate_waste }}</h3></label>
      <Slider v-model="separate_waste" :min="1" :max="5" :step="1" />
      <br>
    </div>

    <div class="shop_plastic_free">
      <label for="shop_plastic_free"><h3>Ich kaufe plastikfrei ein (z.B. unverpackt, Mehrweg): {{ shop_plastic_free }}</h3></label>
      <Slider v-model="shop_plastic_free" :min="1" :max="5" :step="1" />
      <br>
    </div>
  </div>

  <br>
  <div class="additional_information">
    <h2>Weitere Angaben</h2>
    <p>Hier kannst du weitere Angaben machen, die du für relevant hältst.</p>
    <Textarea v-model="additional_information" placeholder="Deine Angaben..." rows="5" cols="196"/>
  </div>

  <br>
  <Button label="Umfrage absenden" icon="pi pi-check" @click="submit_survey"/>

</template>

<style>

  .climate-conscious-behavior {
    width: 50%;
  }

</style>