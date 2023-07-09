<template>
  <div>
    <li v-for="student in students" :key="student.id">
      {{ student.name }} - Scores: {{ student.scores }}
    </li>
    <h1>This is an about page</h1>
    <el-table :data="students" style="width: 100%">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="Name"></el-table-column>
      <el-table-column prop="scores" label="Scores"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import 'element-ui/lib/theme-chalk/index.css'; // 导入Element UI的样式文件
import { ElTable, ElTableColumn } from 'element-ui'; // 导入需要使用的Element UI组件

export default {
  components: {
    ElTable,
    ElTableColumn
  },
  created() {
    Vue.use(ElementUI); // 全局注册Element UI组件
  },
  data() {
    return {
      params: {
        name: '',
        bookNo: '',
        userName: ''
      },
      students: [] // 存储从后端获取的学生数据
    };
  },
  methods: {
    load() {
      // 发起HTTP请求获取学生数据
      // 示例使用axios发送GET请求获取学生数据
      axios.get('http://localhost:9090/Student/list', { params: this.params })
          .then(response => {
            this.students = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    },
    reset() {
      this.params = {
        name: '',
        bookNo: '',
        userName: ''
      };
      this.load();
    }
  },
  mounted() {
    this.load(); // 在组件挂载后获取学生数据
  }
};
</script>
