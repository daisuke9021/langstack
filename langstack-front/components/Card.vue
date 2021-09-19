<template>
  <v-card>
    <h3>{{ cardItem_.title }}</h3>
    <img :src="cardItem_.imageUrl" width="300px" length="230px" />
  </v-card>
</template>
<script lang="ts">
import { Component, Vue, PropSync } from "nuxt-property-decorator";
import Card from "@/domains/Card";

@Component
export default class extends Vue {
  @PropSync("cardItem", { type: Card, default: new Card() })
  cardItem_!: Card;
}
</script>
