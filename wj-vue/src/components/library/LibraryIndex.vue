<!--20210816修改主要是实现按分类查询而注释-->
<!--<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu></SideMenu>
    </el-aside>
    <el-main>
      &lt;!&ndash;<books></books>&ndash;&gt;
      <books class="books-area"></books>
    </el-main>
  </el-container>
</template>
<script>
    import SideMenu from './SideMenu'
    import Books from './Books'
    export default {
        name: 'AppLibrary',
        components: {SideMenu, Books}
    }
</script>
<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>-->

<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch></switch>
      <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <books class="books-area" ref="booksArea"></books>
    </el-main>
  </el-container>
</template>

<script>
    import SideMenu from './SideMenu'
    import Books from './Books'

    export default {
        name: 'AppLibrary',
        components: {Books, SideMenu},
        methods: {
            listByCategory () {
                var _this = this
                const params = {cid: this.$refs.sideMenu.cid}
                this.$axios.post('/libraryManagementMaitain/queryInfoBook', params).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.$refs.booksArea.books = resp.data.data
                    }
                })
            }
        }
    }
</script>

<style scoped>
  .books-area {
    width: 990px;
    margin-left: auto;
    margin-right: auto;
  }
</style>
