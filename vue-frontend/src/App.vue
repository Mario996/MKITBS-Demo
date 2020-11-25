<template>
  <v-app>
    <v-app-bar
      color="white"
      prominent
    >
      <v-img
        max-height="115"
        max-width="200"
        src="./assets/image001.jpg"
      ></v-img>
      <v-spacer></v-spacer>
      <v-btn
        depressed
        color="primary"
        height="50"
        width="150"
        class="my-auto"
        @click="refreshItems()"
      >
        Refresh
      </v-btn>
    </v-app-bar>
    <v-card
      height="820">
      <v-card-title>
        Stock status by location
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
    <v-data-table
      dense
      :headers="headers"
      :items="results"
      :items-per-page="30"
      :search="search"
      class="elevation-1">
        <template
          v-slot:body="{ items }"
        >
          <tbody>
            <tr
              v-for="(item, index) in items"
              :key="index"
              @click="showLocationOnMap()"
            >
              <td>{{ item.Plant || item.pk.plant }}</td>
              <td>{{ item.PlantName }}</td>
              <td>{{ item.StorageLocation || item.pk.storageLocation }}</td>
              <td>{{ item.StorageLocationName }}</td>
              <td>{{ item.MaterialGroupId }}</td>
              <td>{{ item.MaterialGroupName }}</td>
              <td>{{ item.MaterialId || item.pk.materialId }}</td>
              <td>{{ item.MaterialName }}</td>
              <td>{{ item.Quantity }}</td>
              <td>{{ item.UnitOfMeasure }}</td>
            </tr>
          </tbody>
        </template>
      </v-data-table>
    </v-card>
     <!--google-map /-->
  </v-app>
</template>

<script>
import { resultsService } from './services/results.service';
// import GoogleMap from "./components/GoogleMap";

export default {
  components: {
    // GoogleMap
  },
  data: () => ({
    results: [],
    headers: [{text:"Plant", value:"Plant"}, {text:"Plant name", value:"PlantName"}, {text:"Storage location", value:"StorageLocation"},
     {text:"Storage location name", value:"StorageLocationName"}, {text:"Material group id", value:"MaterialGroupId"},{text:"Material group name", value:"MaterialGroupName"},
     {text:"Material id", value:"MaterialId"}, {text:"Material name", value:"MaterialName"}, {text:"Quantity", value:"Quantity"}, {text:"Unit of measure", value:"UnitOfMeasure"}],
    search: '',
  }),
  created(){
    resultsService.getAllResults().then((data) => {
      this.results = data.d.results;
    });
  },
  methods: {
    refreshItems() {
      resultsService.refreshResults().then((data) => {
        this.results = data.body.d.results;
      });
    },
    showLocationOnMap(){
      //implement google maps dialog
    }
  }
};
</script>
