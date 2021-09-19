<template>
  <div>
    <h1>LANGSTACK</h1>
    <card v-touch:swipe.left="swipeHandler" :cardItem.sync="cardItem" />
  </div>
</template>
<script lang="ts">
import Vuee from "vue";
import { Component, Vue } from "nuxt-property-decorator";
import Card from "@/domains/Card";
import Vue2TouchEvents from "vue2-touch-events";

Vuee.use(Vue2TouchEvents);

@Component
export default class Top extends Vue {
  cardItem = new Card();
  cardItems: Card[] = [];

  // MEMO：/staticフォルダ配下がWEbサーバでホスティングされる
  mounted() {
    // TODO axiosでスタブ作成する
    this.cardItems.push(new Card(0, "SEX EDUCATION_001", "/data/card_001.jpg"));
    this.cardItems.push(new Card(1, "SEX EDUCATION_002", "/data/card_002.jpg"));
    this.cardItems.push(new Card(2, "SEX EDUCATION_003", "/data/card_003.jpg"));
    this.cardItems.push(new Card(3, "SEX EDUCATION_004", "/data/card_004.jpg"));
    this.cardItems.push(new Card(4, "SEX EDUCATION_005", "/data/card_005.jpg"));

    this.cardItem = this.cardItems[0];
  }

  swipeHandler() {
    if (this.cardItem.index + 1 === this.cardItems.length) {
      this.cardItem = this.cardItems[0];
    } else {
      this.cardItem = this.cardItems[this.cardItem.index + 1];
    }
  }
}
</script>
