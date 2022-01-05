var app = new Vue({
    el: '#app',
    data: {
        news: []
    },
    methods: {
        newsApi: function () {
            var $this = this;
            axios.get("http://localhost:8080/api/v1/news?key=bdGW7phynRHVbXpF3319QIQPKtCoJ72nObLribDqcpUUgFxR5w1mc7BbSlkjnQtclE4PSNzMJS00KaclhuPJXNNfcn3MXBUycPtuNPTlhMZAiw3H9ufQLlUw9pDM6TD9bBITsh3TeJQETkHeHH5r4x").then(function(response) {
                $this.news = response.data.rss.channel.item;
                console.log($this.news);
            });

        }
    },
    created: function() {
        this.newsApi();
    }
})