function solve() {
    const textarea=document.getElementsByTagName('textarea')[0];
    const generateBtn=document.querySelector("#exercise > button:nth-child(3)");
    const resultBox=document.querySelector("#exercise > textarea:nth-child(5)");
    const buyBtn=document.querySelector("#exercise > button:nth-child(6)");
    const checkBoxes=document.getElementsByTagName("input");
    const tableBody=document.querySelector("tbody");


    generateBtn.addEventListener('click',addItem);

    buyBtn.addEventListener('click',findChecked);
    let order = [];
    let totalPrice = 0;
    let decFactor = 0;

    function addItem() {
        // let list=JSON.parse('[{"name": "Sofa", "img": "https://res.cloudinary.com/maisonsdumonde/image/upload/q_auto,f_auto/w_200/img/grey-3-seater-sofa-bed-200-13-0-175521_9.jpg", "price": 150, "decFactor": 1.2},' +
        //     '{"img":"https://cdn.jysk.ca/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/7/0/7011671065_3dr_sonoma.jpg", "name": "Wardrobe", "price": "120", "decFactor":"1.2"}]');
        let list=JSON.parse(textarea.value);
        for (let item of list) {
            let tr = newElement('TR');
            let tdImg = newElement('TD');
            tdImg.innerHTML = `<img src ="${item['img']}">`;
            let tdName = newTdP(item['name']);
            let tdPrice = newTdP(item['price']);
            let tdFactor = newTdP(item['decFactor']);
            let tdCheck = newElement('TD');
            let inp = newElement('INPUT');
            inp.type = 'checkbox';
            tdCheck.appendChild(inp);
            tr.appendChild(tdImg);
            tr.appendChild(tdName);
            tr.appendChild(tdPrice);
            tr.appendChild(tdFactor);
            tr.appendChild(tdCheck);
            tableBody.appendChild(tr);
        }
    }

    function printResult(order, totalPrice, decFactor) {
        resultBox.value+=`Bought furniture: ${order.join(', ')}\n`+
        `Total price: ${totalPrice.toFixed(2)}\n`+
        `Average decoration factor: ${(decFactor/order.length)}`;
    }

    function findChecked() {
        Array.from(tableBody.children)
            .filter(c=>c.children[4].children[0].checked)
            .forEach(c=>addToOrder(c.children));
        // let trElements = Array.from(document.getElementsByTagName('tr'));
        // for (let i = 2; i < trElements.length; i++) {
        //     if (trElements[i].children[4].children[0].checked) {
        //         addToOrder(trElements[i].children)
        //     }
        // }
        printResult(order,totalPrice,decFactor);
    }

    function addToOrder(itemRows) {
        order.push(itemRows[1].textContent);
        totalPrice+=Number(itemRows[2].textContent);
        decFactor+=Number(itemRows[3].textContent);
    }

    function newElement(e) {
        return document.createElement(e)
    }

    function newTdP(t) {
        let td=newElement('TD');
        let p=newElement('P');
        p.textContent=`${t}`;
        td.appendChild(p);
        return td
    }
}