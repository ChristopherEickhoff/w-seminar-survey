<script setup>
import { ref, onMounted, computed } from 'vue'
import { Bar } from 'vue-chartjs'
import {
  Chart,
  BarElement,
  CategoryScale,
  LinearScale,
  Tooltip,
  Legend
} from 'chart.js'

Chart.register(BarElement, CategoryScale, LinearScale, Tooltip, Legend)

const results = ref([])

onMounted(async () => {
  const res = await fetch('http://localhost:8081/api/results')
  results.value = await res.json()
})

function countByField(field) {
  const counts = {}
  for (const r of results.value) {
    const val = r[field]
    counts[val] = (counts[val] || 0) + 1
  }
  return counts
}

const chartFields = [
  { field: 'age', title: 'Altersverteilung' },
  { field: 'sex', title: 'Geschlecht' },
  { field: 'plz', title: 'PLZ' },
  { field: 'residential_area', title: 'Wohnort' },
  { field: 'school_education', title: 'Schulabschluss' },
  { field: 'monthly_income', title: 'Einkommen' },
  { field: 'public_transportation_availability', title: 'ÖPNV-Verfügbarkeit' },
  { field: 'main_transportation_means', title: 'Hauptverkehrsmittel' },
  { field: 'public_transportation_usage', title: 'ÖPNV-Nutzung' },
  { field: 'regional_and_seasonal_food', title: 'Regional/Saisonal' },
  { field: 'vegetarian_or_vegan_diet', title: 'Vegetarisch/Vegan' },
  { field: 'avoid_flying', title: 'Flugreisen vermeiden' },
  { field: 'use_secondhand_or_durable_products', title: 'Secondhand/Langlebig' },
  { field: 'save_energy_at_home', title: 'Energie sparen' },
  { field: 'separate_waste', title: 'Müll trennen' },
  { field: 'shop_plastic_free', title: 'Plastikfrei einkaufen' }
]

const charts = computed(() =>
  chartFields.map(({ field, title }) => {
    const counts = countByField(field)
    return {
      title,
      data: {
        labels: Object.keys(counts),
        datasets: [
          {
            label: 'Anzahl',
            data: Object.values(counts),
            backgroundColor: '#b6f5d8'
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: { display: false }
        },
        scales: {
          y: { beginAtZero: true, precision: 0 }
        }
      }
    }
  })
)

const chartRows = computed(() => {
  const arr = []
  for (let i = 0; i < charts.value.length; i += 2) {
    arr.push([charts.value[i], charts.value[i + 1]].filter(Boolean))
  }
  return arr
})
</script>

<template>
  <div>
    <h1>Ergebnisse</h1>
    <div v-if="results.length === 0">Noch keine Ergebnisse vorhanden.</div>
    <div v-else>
      <div class="charts-row" v-for="row in chartRows" :key="row[0]?.title">
        <div v-for="(chart, idx) in row" :key="chart.title" class="chart-container">
          <h2>{{ chart.title }}</h2>
          <div style="height:320px;">
            <Bar :data="chart.data" :options="chart.options" />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.charts-row {
  display: flex;
  gap: 2rem;
  justify-content: center;
  margin-bottom: 2rem;
}
.chart-container {
  flex: 1 1 0;
  max-width: 600px;
  background: #fff;
  border-radius: 8px;
  padding: 1rem;
  box-shadow: 0 2px 8px rgba(0,0,0,0.08);
}
</style>