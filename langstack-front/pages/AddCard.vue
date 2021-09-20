<template>
  <div>
    <h1 class="mb-5">ADD CARD PAGE</h1>
    <v-row>
      <v-col>
        <v-btn @click="switchGenreForm" class="mb-2">
          ADD {{ genreFormText }} GENRE
        </v-btn>
        <v-text-field
          v-model="inputGenre"
          v-if="isNewGenreForm"
          outlined
          placeholder="GENRE"
        />
        <v-select
          v-model="inputGenre"
          v-else
          outlined
          :items="genres"
          item-value="id"
          item-text="name"
        />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-text-field v-model="inputTitle" outlined placeholder="TITLE" />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-textarea v-model="inputContent" outlined placeholder="CONTENT" />
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-file-input placeholder="IMAGE" @change="imageChange" />
        <v-img v-if="imagePreview" :src="imagePreview" />
      </v-col>
    </v-row>
    <v-row align="center">
      <v-col class="text-center">
        <v-btn>ADD</v-btn>
      </v-col>
    </v-row>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from "nuxt-property-decorator";

import ServiceFactory from "@/infras/ServiceFactory";
import GenreService from "@/domains/genre/GenreService";

import Genre from "@/domains/genre/Genre";

@Component
export default class AddCard extends Vue {
  genreService!: GenreService;

  // TODO：入力情報は「カード入力用のオブジェクト(InputCardForm)で受け渡していいかも
  inputGenre = "";
  inputTitle = "";
  inputContent = "";

  genres: Genre[] = [];

  isNewGenreForm = false;
  genreFormText = "NEW";

  imagePreview: string | ArrayBuffer | null = "";

  async fetch() {
    this.genreService = await ServiceFactory.getGenreService();
    this.genres = await this.genreService.getAllGenre();
  }

  switchGenreForm() {
    this.isNewGenreForm = !this.isNewGenreForm;
    this.inputGenre = "";
    this.genreFormText = this.isNewGenreForm ? "EXISTING" : "NEW";
  }

  // MEMO：BASE64エンコードの手順
  // 1. FileReader()を生成
  // 2. readAsDataURLでファイルを読み込む
  // 3. load完了したら読込結果(result)を取得するイベントを作成
  // ※ 3のresult=dataURL。そのままpreviewに使える。
  // ※ サーバに送信する場合は頭文字部分(/data~~~~)を切り抜く。]
  imageChange(file: File) {
    // 写真が削除された場合のnullチェック
    if (file !== undefined && file !== null) {
      const fr = new FileReader();
      fr.readAsDataURL(file);
      fr.addEventListener("load", () => {
        this.imagePreview = fr.result;
      });
    } else {
      this.imagePreview = "";
    }
  }

  // TODO 登録処理を行う際に、base64の文字を切り取る
}
</script>
