Vue.createApp({
    data() {
        return {
            clientInfo: [],
            accountInfo: {},
            errorToats: null,
            errorMsg: null,
        }
    },
    methods: {
        getDataClient: function () {
            axios.get("/api/clients/current")
                .then((response) => {
                    //obtiene los datos del cliente actual y autenticado
                    this.clientInfo = response.data;
                })
                .catch((error) => {
                    // Por si no hay un cliente autenticado y no obtiene nada
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
        getData: function () {
            const urlParams = new URLSearchParams(window.location.search);
            const id = urlParams.get('id');
            axios.get(`/api/accounts/${id}`)
                .then((response) => {
                    //get client ifo
                    this.accountInfo = response.data;
                    this.accountInfo.transactions.sort((a, b) => (b.id - a.id))
                })
                .catch((error) => {
                    // handle error
                    this.errorMsg = "Error getting data";
                    this.errorToats.show();
                })
        },
        formatDate: function (date) {
            return new Date(date).toLocaleDateString('en-gb');
        },
        signOut: function () {
            axios.post('/api/logout')
                .then(response => window.location.href = "/web/index.html")
                .catch(() => {
                    this.errorMsg = "Sign out failed"
                    this.errorToats.show();
                })
        },
        login: function (){
            this.modelLogin.show()
        },
        seguidoresYPublico: function () {
            window.location.href = './seguidoresYPublico.html';
        },
        produccionAudioVisual: function (){
            window.location.href = './produccion-audio-visual.html';
        },
        organizaciones: function (){
            window.location.href = './organizaciones.html';
        },
        eventosSociales: function (){
            window.location.href = './eventos-sociales.html'
        },
    },
    mounted: function () {
        this.modelLogin = new bootstrap.Modal(document.getElementById('login'));
        /* this.errorToats = new bootstrap.Toast(document.getElementById('danger-toast'));
        this.getData();
        this.getDataClient(); */
    }
}).mount('#app')