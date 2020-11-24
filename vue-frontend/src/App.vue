<template>
  <v-app>
   <v-data-table
    :headers="headers"
    :items="results"
    :items-per-page="50"
    class="elevation-1"
  ></v-data-table>
  </v-app>
</template>

<script>
import { resultsService } from './services/results.service';

export default {
  data: () => ({
    results: [],
    headers: [{text:"Id", value:"id"}, {text:"Plant", value:"Plant"}, {text:"Plant name", value:"PlantName"}, {text:"Storage location", value:"StorageLocation"},
     {text:"Storage location name", value:"StorageLocationName"}, {text:"Material group id", value:"MaterialGroupId"},{text:"Material group name", value:"MaterialGroupName"},
     {text:"Material id", value:"MaterialId"}, {text:"Material name", value:"MaterialName"}, {text:"Quantity", value:"Quantity"}, {text:"Unit of measure", value:"UnitOfMeasure"}],
  }),
  created(){
    resultsService.refreshResults().then((data) => {
      console.log(data);
      this.results = data.body.d.results;
    });
  }
};
</script>
