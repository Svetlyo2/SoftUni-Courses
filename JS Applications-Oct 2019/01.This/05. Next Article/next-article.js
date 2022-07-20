function getArticleGenerator(articles) {
    const divContent=document.getElementById('content');
    let count=0;
    return  function () {
        if (count<articles.length){
            let article=document.createElement('article');
            article.textContent=articles[count];
            divContent.appendChild(article);
            count++;
        }
    }
}
