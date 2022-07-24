(() => {
     renderCatTemplate();

     async function renderCatTemplate() {
         const source=await fetch('http://localhost:63342/07.%20JS-Applications-Templating-Exercise/02.%20HTTP%20Status%20Cats/templates/all-cats.hbs')
             .then(res=>res.text());
         const template=Handlebars.compile(source);
         const context={cats:window.cats};
         const catsHtml=template(context);
         document.getElementById('allCats')
             .innerHTML=catsHtml;
     }
})();
function display(btn) {
     const info=btn.parentNode.getElementsByClassName('status')[0];
     const process={
          none:()=>showInfo(),
          block:()=>hideInfo()
     };
     process[info.style['display']]();
     function hideInfo() {
          info.style.display='none';
          btn.textContent='Show status code';
     }
     function showInfo() {
          info.style.display='block';
          btn.textContent='Hide status code';
     }
}
