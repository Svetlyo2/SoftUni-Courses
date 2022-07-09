function solve() {

    const data = Array.from(document.querySelectorAll("tbody > tr"));
    const searchField = document.getElementById("searchField");
    const searchBtn = document.getElementById("searchBtn");

    function search() {
        data.map(r=>r.classList.remove('select'));
        if (searchField.value.trim() === '') return;
        data.filter(r=> {
            // console.log(r.innerText);
            return r.innerText.toLowerCase().includes(searchField.value.toLowerCase());
        }).map(res => res.classList.add('select'));
        searchField.value='';
    }
    searchBtn.addEventListener('click', search);
}