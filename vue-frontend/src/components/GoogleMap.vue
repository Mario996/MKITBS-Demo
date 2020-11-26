<template>
  <div>
    <gmap-map
      :center="{ lat: 45.209, lng: 19.727 }"
      :zoom="14"
      style="width:500px;  height: 500px;"
    >
      <gmap-marker
        ref="myMarker"
        :position="google && new google.maps.LatLng(45.209, 19.727)"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>

<script>
import {gmapApi} from 'vue2-google-maps'

export default {
  name: "GoogleMap",
  computed: {
    google: gmapApi
  }
};
</script>