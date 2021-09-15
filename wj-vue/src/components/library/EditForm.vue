<template>
  <div>
    <i class="el-icon-circle-plus-outline"  @click="addBook"></i>
    <!--修改图书-->
    <el-dialog
    title="新增/修改图书"
    :visible.sync="dialogFormVisible"
    @close="clear">
    <el-form v-model="form" style="text-align: left" ref="dataForm">
      <el-form-item label="书名" :label-width="formLabelWidth" prop="title">
        <el-input v-model="form.title" autocomplete="off" placeholder="不加《》"></el-input>
      </el-form-item>
      <el-form-item label="作者" :label-width="formLabelWidth" prop="author">
        <el-input v-model="form.author" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="出版日期" :label-width="formLabelWidth" prop="pubDate">
        <el-input v-model="form.pubDate" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="出版社" :label-width="formLabelWidth" prop="press">
        <el-input v-model="form.press" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="封面" :label-width="formLabelWidth" prop="cover">
        <el-input v-model="form.cover" autocomplete="off" placeholder="图片 URL"></el-input>
        <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
      </el-form-item>
      <el-form-item label="简介" :label-width="formLabelWidth" prop="abs">
        <el-input type="textarea" v-model="form.abs" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="分类" :label-width="formLabelWidth" prop="cid">
        <el-select v-model="form.category.typeId" placeholder="请选择分类">
          <el-option label="文学" value="1"></el-option>
          <el-option label="流行" value="2"></el-option>
          <el-option label="文化" value="3"></el-option>
          <el-option label="生活" value="4"></el-option>
          <el-option label="经管" value="5"></el-option>
          <el-option label="科技" value="6"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item prop="bookId" style="height: 0">
        <el-input type="hidden" v-model="form.bookId" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="onSubmit">确 定</el-button>
      <el-button @click="dialogFormVisible = false">取 消</el-button>
    </div>
  </el-dialog>

  </div>
</template>

<script>
    import ImgUpload from './ImgUpload'
    export default {
        name: 'EditForm',
        components: {ImgUpload},
        data () {
            return {
                dialogFormVisible: false,
                submitType: '', // 修改/新增标志
                form: {
                    bookId: '',
                    title: '',
                    author: '',
                    pubDate: '',
                    press: '',
                    cover: '',
                    abs: '',
                    category: {
                        typeId: '',
                        typeName: ''
                    }
                },
                formLabelWidth: '120px'
            }
        },
        methods: {
            clear () {
                this.form = {
                    bookId: '',
                    title: '',
                    author: '',
                    pubDate: '',
                    press: '',
                    cover: '',
                    abs: '',
                    category: {
                        typeId: '',
                        typeName: ''
                    }
                }
            },
            addBook () {
                this.dialogFormVisible = true
                this.submitType = 'add'
            },
            onSubmit () {
                // add新增 update修改
                if (this.submitType === 'add') {
                    this.$axios.post('/libraryManagementMaitain/insertBookInfo', {
                        bookId: this.form.bookId,
                        cover: this.form.cover,
                        title: this.form.title,
                        author: this.form.author,
                        pubDate: this.form.pubDate,
                        press: this.form.press,
                        abs: this.form.abs,
                        cid: this.form.category.typeId
                    }).then(resp => {
                        if (resp && resp.status === 200) {
                            this.dialogFormVisible = false
                            this.$message({type: 'info', message: '新增成功!'})
                            this.$emit('onSubmit')
                        }
                    }).catch(() => {
                        this.$message({type: 'info', message: '新增失败!'})
                    })
                } else {
                    this.$axios.post('/libraryManagementMaitain/updateBookInfo', {
                        bookId: this.form.bookId,
                        cover: this.form.cover,
                        title: this.form.title,
                        author: this.form.author,
                        pubDate: this.form.pubDate,
                        press: this.form.press,
                        abs: this.form.abs,
                        cid: this.form.category.typeId
                    }).then(resp => {
                        if (resp && resp.status === 200) {
                            this.dialogFormVisible = false
                            this.$message({type: 'info', message: '修改成功!'})
                            this.$emit('onSubmit')
                        }
                    }).catch(() => {
                        this.$message({type: 'info', message: '修改失败!'})
                    })
                }
            },
            // 图片上传20210914
            uploadImg () {
                this.form.cover = this.$refs.imgUpload.url
            }
        }
    }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
</style>
