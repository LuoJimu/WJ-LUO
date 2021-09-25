<template>
  <div class="articles-area">
    <el-card style="text-align: left;width: 990px;margin: 35px auto 0 auto">
      <div v-for="article in articles" :key="article.articleId">
        <span style="font-size: 20px"><strong>{{article.articleTitle}}</strong></span>
        <el-divider content-position="left">{{article.articleDate}}</el-divider>
        <div class="markdown-body">
          <div v-html="article.articleContentHtml"></div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
  export default {
      name: 'ArticleDetails',
      data () {
          return {
              articles: []
          }
      },
      mounted () {
          this.loadArticle()
      },
      methods: {
          loadArticle () {
              var _this = this
              const params = {articleId: this.$route.query.id}
              this.$axios.post('/jotterManagementMaitain/queryJotterArticleInfo', params).then(resp => {
                  if (resp && resp.status === 200) {
                      _this.articles = resp.data.data
                  }
              })
          }
      }
  }
</script>

<style scoped>
  @import "../common/styles/markdown.css";
</style>
