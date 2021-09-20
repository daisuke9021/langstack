<template>
  <div>
    <h1 class="mb-3">LANGSTACK TOP画面</h1>
    <!-- MEMO：nuxt-link toで画面遷移 -->
    <p><nuxt-link to="AddCard">ADD CARD</nuxt-link></p>
    <p><nuxt-link to="ReviseTop">REVISE CARD</nuxt-link></p>
    <p><nuxt-link to="AxiosPractice">AxiosPractice</nuxt-link></p>
  </div>
</template>
<script lang="ts">
import { Vue, Component } from "nuxt-property-decorator";

@Component
export default class Top extends Vue {}
</script>
