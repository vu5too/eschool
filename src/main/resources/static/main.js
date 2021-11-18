const baseUrl = 'http://localhost:8081/students'

const App = {
    data() {
        return {
            students: [],
            name: '',
            email: '',
            show: false,
        }
    },
    mounted() {
        this.get()
    },
    methods: {
        get() {
            fetch(baseUrl)
                .then(result => result.json())
                .then(data => this.students = data)
                .catch(err => console.log(err.message))
        },

        save() {
            const student = {'name' : this.name, 'email' : this.email}
            const requestOptions = {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(student)
            }

            fetch(baseUrl, requestOptions)
                .then(response => {
                    if (response.ok) {
                        this.students.push(student)
                        this.get()
                        this.name = ''
                        this.email = ''
                        this.modalAction();
                    }
                })
        },
        del(student) {
            if (this.students.includes(student)) {
                fetch(baseUrl +'/' + student.id, {method: 'DELETE'}).then(result => {
                    if (result.ok) {
                        this.students.splice(this.students.indexOf(student), 1)
                    }
                })
            }
        },
        modalAction() {
            this.show = !this.show
            console.log(this.show)
        },
    },
}
const app = Vue.createApp(App)


app.mount('#app')







