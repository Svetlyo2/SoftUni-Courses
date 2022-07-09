function solve() {
    const products={
        "Bread": 0.80,
        "Milk": 1.09,
        "Tomatoes": 0.99
    }
    const addButtons= Array.from(document.querySelectorAll('.add-product'));
    const basket=document.querySelector("textarea");
    const checkoutButton=document.querySelector(".checkout");
    let sum=0;
    let productList=new Set;
    let basketDetails='';

    function addProduct(e) {
        const product=e.target.parentElement.parentElement;
        let productName=product.children[1].firstElementChild.innerHTML;
        productList.add(productName);
        sum+=products[productName];
        basketDetails+=`Added ${productName} for ${products[productName].toFixed(2)} to the cart.\n`;
        basket.textContent=basketDetails;
    }
    function checkout(){
        let list=[...productList].join(', ');
        basketDetails+=`You bought ${list} for ${sum.toFixed(2)}.`
        basket.textContent=basketDetails;
        addButtons.map(b=>b.disabled = true);
        checkoutButton.disabled = true;
    }

    addButtons.map(b=> b.addEventListener("click", addProduct));
    checkoutButton.addEventListener("click",checkout)
}
