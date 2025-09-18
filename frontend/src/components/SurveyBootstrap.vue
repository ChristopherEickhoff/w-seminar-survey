<script setup lang="ts">
import { ref } from 'vue'
import Listbox from 'primevue/listbox'
import InputMask from 'primevue/inputmask'
import Slider from 'primevue/slider'
import Textarea from 'primevue/textarea';
import Button from 'primevue/button';
import Editor from 'primevue/editor';


const age = ref('30-44') 
const age_options = ['unter 18', '18-29', '30-44', '45-59', '60+']

const sex = ref('männlich')
const sex_options = ['männlich', 'weiblich', 'divers', 'keine Angabe']

const plz = ref('')
const plz_mask = '99999'

const residential_area = ref('Stadt')
const residential_area_options = ['Stadt', "Landkreis"]

const school_education = ref('Abitur')
const school_education_options = ['kein Abschluss', 'Hauptschulabschluss', 'Realschulabschluss', 'Abitur', 'Studium']

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

  await fetch('http://localhost:8081/api/submit', {
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
  <div class="container py-4 d-flex justify-content-center">
    <div class="survey-card w-100" style="max-width: 900px;">
      <h1 class="mb-3 display-5 text-center">W Seminar Umfrage</h1>
      <form @submit.prevent="submit_survey">
        <div class="row g-3">
          <div class="col-12 col-md-6">
            <div class="general-information mb-4">
              <h2 class="h4 mb-2">Allgemeine Angaben</h2>
              <div class="mb-2">
                <label for="age" class="form-label">Alter</label>
                <Listbox v-model="age" :options="age_options" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="sex" class="form-label">Geschlecht</label>
                <Listbox v-model="sex" :options="sex_options" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="plz" class="form-label">Postleitzahl</label>
                <InputMask v-model="plz" :mask="plz_mask" placeholder="12345" class="form-control" />
              </div>
              <div class="mb-2">
                <label for="residential_area" class="form-label">Wohnort</label>
                <Listbox v-model="residential_area" :options="residential_area_options" class="w-100" />
              </div>
            </div>
            <div class="socioeconomic_characteristics mb-4">
              <h2 class="h4 mb-2">Sozioökonomische Merkmale</h2>
              <div class="mb-2">
                <label for="school_education" class="form-label">Schulabschluss</label>
                <Listbox v-model="school_education" :options="school_education_options" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="monthly_income" class="form-label">Monatliches Nettoeinkommen</label>
                <Listbox v-model="monthly_income" :options="monthly_income_options" class="w-100" />
              </div>
            </div>
          </div>
          <div class="col-12 col-md-6">
            <div class="mobility_and_public_transportation mb-4">
              <h2 class="h4 mb-2">Mobilität und ÖPNV</h2>
              <div class="mb-2">
                <label for="public_transportation_availability" class="form-label">Verfügbarkeit ÖPNV</label>
                <Listbox v-model="public_transportation_availability" :options="public_transportation_availability_options" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="main_transportation_means" class="form-label">Hauptverkehrsmittel</label>
                <Listbox v-model="main_transportation_means" :options="main_transportation_means_options" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="public_transportation_usage" class="form-label">ÖPNV Nutzung</label>
                <Listbox v-model="public_transportation_usage" :options="public_transportation_usage_options" class="w-100" />
              </div>
            </div>
            <div class="climate-conscious-behavior mb-4">
              <h2 class="h4 mb-2">Klimabewusstes Verhalten <span class="fs-6">(1 = nie, 5 = immer)</span></h2>
              <div class="mb-2">
                <label for="regional_and_seasonal_food" class="form-label">Regionale & saisonale Lebensmittel: <b>{{ regional_and_seasonal_food }}</b></label>
                <Slider v-model="regional_and_seasonal_food" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="vegetarian_or_vegan_diet" class="form-label">Vegetarisch/vegan: <b>{{ vegetarian_or_vegan_diet }}</b></label>
                <Slider v-model="vegetarian_or_vegan_diet" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="avoid_flying" class="form-label">Flugreisen vermeiden: <b>{{ avoid_flying }}</b></label>
                <Slider v-model="avoid_flying" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="use_secondhand_or_durable_products" class="form-label">Secondhand/langlebige Produkte: <b>{{ use_secondhand_or_durable_products }}</b></label>
                <Slider v-model="use_secondhand_or_durable_products" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="save_energy_at_home" class="form-label">Energie sparen: <b>{{ save_energy_at_home }}</b></label>
                <Slider v-model="save_energy_at_home" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="separate_waste" class="form-label">Mülltrennung: <b>{{ separate_waste }}</b></label>
                <Slider v-model="separate_waste" :min="1" :max="5" :step="1" class="w-100" />
              </div>
              <div class="mb-2">
                <label for="shop_plastic_free" class="form-label">Plastikfrei einkaufen: <b>{{ shop_plastic_free }}</b></label>
                <Slider v-model="shop_plastic_free" :min="1" :max="5" :step="1" class="w-100" />
              </div>
            </div>
          </div>
        </div>
        <div class="col-12">
          <div class="additional_information mb-3">
            <h2 class="h5 mb-2">Weitere Angaben</h2>
            <Textarea v-model="additional_information" placeholder="Deine Angaben..." rows="4" class="form-control"/>
          </div>
        </div>
        <div class="col-12 text-center">
          <Button label="Umfrage absenden" icon="pi pi-check" type="submit" class="px-4 py-2"/>
        </div>
        </form>
      </div>
    </div>
</template>

<style>

  .p-listbox .p-listbox-list .p-listbox-item {
    color: #222;
    background: #fff;
  }
  .p-listbox .p-listbox-list .p-listbox-item.p-highlight {
    color: #222;
    background: #b6f5d8;
  }

  .survey-card {
    background: #fff;
    border-radius: 1rem;
    box-shadow: 0 2px 16px rgba(0,0,0,0.07);
    padding: 2rem 1.5rem;
  }
  .form-label {
    font-weight: bold;
    margin-bottom: 0.2rem;
  }
  .mb-2 {
    margin-bottom: 0.5rem 
  }
  .mb-3 {
    margin-bottom: 1rem 
  }
  .mb-4 {
    margin-bottom: 1.5rem 
  }
  .display-5 {
    font-size: 2.2rem;
    font-weight: 600;
  }

</style>