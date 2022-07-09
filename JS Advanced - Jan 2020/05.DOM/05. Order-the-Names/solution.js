function solve() {
let names={A:[],
    B:[],
    C:[],
    D:[],
    E:[],
    F:[],
    G:[],
    H:[],
    I:[],
    J:[],
    K:[],
    L:[],
    M:[],
    N:['Nixon'],
    O:[],
    P:['Peterson'],
    Q:[],
    R:[],
    S:[],
    T:[],
    U:[],
    V:[],
    W:[],
    X:[],
    Y:[],
    Z:[]
};
    const input=document.querySelector("#exercise > article > input");
    const addBtn=document.querySelector("#exercise button");
    addBtn.addEventListener('click',addName);

    function addName(e) {
        let name=input.value;
        if (name === '') return '';
        let firstLetter=name.substring(0,1).toUpperCase();
        name = firstLetter + name.substring(1).toLowerCase();
        let childNum=firstLetter.charCodeAt(0)-64;
        names[firstLetter].push(name);
        let namesList=names[firstLetter].join(', ');
        document.querySelector(`#exercise > div > ol > li:nth-child(${childNum})`).textContent=namesList;
        input.value='';
    }
}