<template>
  <v-dialog v-model="showDialog_">
    <v-card>
      <v-container>
        <v-row>
          <v-col cols="6">
            <h3 class="mt-3">
              <v-chip class="mr-3" color="primary">TITLE</v-chip>
              {{ card_.title }}
            </h3>
            <h3 class="mt-3">
              <v-chip class="mr-3" color="primary">GENRE</v-chip>{{ card_.genre.name }}
            </h3>
            <h3 class="mt-3"><v-chip color="primary">CONTENT</v-chip></h3>
            <!-- v-text内だと改行コード「\n」で改行される -->
            <div class="mt-5 ml-5" style="white-space: pre-wrap;" v-text="card_.content" />
          </v-col>
          <v-col cols="6">
            <v-img :src="card_.imageUrl" width="550px" length="440px" />
          </v-col>
        </v-row>
      </v-container>
    </v-card>
  </v-dialog>
</template>
<script lang="ts">
import { Vue, Component, PropSync } from "nuxt-property-decorator";
import Card from "@/domains/card/Card";

@Component
export default class CardDialog extends Vue {
  @PropSync("showDialog", { type: Boolean, default: false })
  showDialog_!: boolean;

  @PropSync("card", { type: Card, default: new Card() })
  card_!: Card;
}
</script>
