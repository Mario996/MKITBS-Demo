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
        :loading="loadingAll"
        :disabled="loadingAll"
        @click="refreshItems()"
      >
        Refresh
      </v-btn>
    </v-app-bar>
    <v-card
      height="820">
      <v-card-title>
        <v-row>
          <v-col
          cols="12"
          md="3"
          >
            <p class="pt-4">
              Stock status by location
            </p>
          </v-col>
          <v-col
          cols="12"
          md="2"
          >
            <v-text-field
              v-model="plant"
              append-icon="mdi-magnify"
              label="Plant"
              single-line
              hide-details
            ></v-text-field>
          </v-col>
          <v-col
          cols="12"
          md="3"
          >
            <v-text-field
              v-model="storageLocation"
              append-icon="mdi-magnify"
              label="Storage location"
              single-line
              hide-details
            ></v-text-field>
          </v-col>
          <v-col
          cols="12"
          md="3"
          >
            <v-text-field
              v-model="materialGroupId"
              append-icon="mdi-magnify"
              label="Material group id"
              single-line
              hide-details
            ></v-text-field>
          </v-col>
          <v-btn
            depressed
            color="primary"
            height="50"
            width="150"
            class="my-auto"
            :loading="loadingFilter"
            :disabled="loadingFilter"
            @click="filterItems()"
          >
            Filter
          </v-btn>
        </v-row>
      </v-card-title>
    <v-data-table
      dense
      :headers="headers"
      :items="results"
      :items-per-page="30"
      class="elevation-1">
        <template
          v-slot:body="{ items }"
        >
          <tbody>
            <tr
              v-for="(item, index) in items"
              :key="index"
              @click="showLocationOnMap()"
              style="cursor: pointer;"
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
    <v-dialog
      v-model="dialog"
      width="500"
    >
      <google-map/>
    </v-dialog>
  </v-app>
</template>

<script>
import { resultsService } from './services/results.service';
import GoogleMap from "./components/GoogleMap";

export default {
  components: {
     GoogleMap
  },
  data: () => ({
    results: [],
    headers: [{text:"Plant", value:"Plant"}, {text:"Plant name", value:"PlantName"}, {text:"Storage location", value:"StorageLocation"},
     {text:"Storage location name", value:"StorageLocationName"}, {text:"Material group id", value:"MaterialGroupId"},{text:"Material group name", value:"MaterialGroupName"},
     {text:"Material id", value:"MaterialId"}, {text:"Material name", value:"MaterialName"}, {text:"Quantity", value:"Quantity"}, {text:"Unit of measure", value:"UnitOfMeasure"}],
    plant: '',
    storageLocation: '',
    materialGroupId: '',
    dialog: false,
    loadingAll: false,
    loadingFilter: false,
  }),
  created(){
    resultsService.getAllResults().then((data) => {
      this.results = data.d.results;
    });
  },
  methods: {
    refreshItems() {
      this.loadingAll = true;
      resultsService.refreshResults().then((data) => {
        this.loadingAll = false;
        this.results = data.body.d.results;
      });
    },
    filterItems() {
      this.loadingFilter = true;
      resultsService.filterAllResults(this.plant, this.storageLocation, this.materialGroupId).then((data) =>
        {
          this.loadingFilter = false;
          this.results = data.body.d.results;
        }
      );
    },
    showLocationOnMap(){
      this.dialog = true;
    }
  }
};
</script>
