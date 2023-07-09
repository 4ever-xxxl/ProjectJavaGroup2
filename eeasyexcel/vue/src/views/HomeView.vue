
<template>
  <div>
    <ul>

    </ul>
  </div>
</template>




<script>

export default {
  data() {
    return {
      students: [] // 用于存储从后端获取的学生数据
    };
  },
  mounted() {
    this.fetchStudents(); // 在组件挂载后获取学生数据
  },
  methods: {
    fetchStudents() {
      // 发起HTTP请求获取学生数据
      // 可以使用axios、fetch等库来发送请求
      // 示例使用axios发送GET请求获取学生数据
      axios.get('http://localhost:9090/Student/list')
          .then(response => {
            this.students = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
};
</script>