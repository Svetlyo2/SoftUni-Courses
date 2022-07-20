//04. Table

function solve(){
   const trs=Array.from(document.querySelectorAll("body > table > tbody > tr"));

  trs.map(tr=>tr.addEventListener('click',function () {
      if (this.hasAttribute('style')){
          this.removeAttribute('style');
      } else {
          trs.map(t=>t.removeAttribute('style'));
          this.style.backgroundColor="#413f5e";
      }
  }))
}
