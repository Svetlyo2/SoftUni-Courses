function encodeAndDecodeMessages() {
    const areas=document.querySelectorAll("#main textarea");
    const buttons=document.querySelectorAll("#main  button");
    let output=areas[1];

    Array.from(buttons).map(b=>b.addEventListener('click',function (e) {
        let input=areas[0];
        if (e.target===buttons[0]){
            if (input.value==='') return;
            // console.log(encode(input.value));
            output.value=encode(input.value);
            input.value='';
        } else {
            if (output.value==='') return;
            output.value=decode(output.value);
        }
    }));

    function encode(t) {
        return  t.split('')
            .map(c=>String.fromCharCode(c.charCodeAt(0)+1))
            .join('');
    }
    function decode(t) {
        return t.split('')
            .map(c=>String.fromCharCode(c.charCodeAt(0)-1))
            .join('');
    }
}