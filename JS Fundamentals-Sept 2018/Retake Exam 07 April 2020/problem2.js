
function solve(arr) {
    let pattern;
    let current='';
    let output='';
    for (let line of arr) {
        if (line.length===4){
            let [command,secondaryCommand, position, word]=line;
            position=Number(position);
            if (command==='filter'){
                if (secondaryCommand==='UPPERCASE'){
                    pattern=/[A-Z]/gm;
                    let result=word.match(pattern);
                    output+=result[position-1];
                } else if (secondaryCommand==='LOWERCASE'){
                    pattern=/[a-z]/gm;
                    let result=word.match(pattern);
                    output+=result[position-1];
                } else if (secondaryCommand==='NUMS'){
                    pattern=/[0-9]/gm;
                    let result=word.match(pattern);
                    output+=result[position-1];
                }
            } else if (command==='sort'){
                let wordArr=Array.from(word);
                if (secondaryCommand==='A'){
                    wordArr.sort( (a,b)=>a.localeCompare(b));
                    output+=wordArr[position-1];
                }
                if (secondaryCommand==='Z'){
                    wordArr.sort( (a,b)=>b.localeCompare(a));
                    output+=wordArr[position-1];
                }
            } else if (command==='rotate'){
                secondaryCommand=Number(secondaryCommand);
                for (let i = 0; i < secondaryCommand; i++) {
                    current=word.substring(word.length-1)+word.substring(0,word.length-1);
                    word=current;
                }
                output+=word.substring(position-1,position);
            }
        }
        if (line.length===3){
            let [command, position, word]=line;
            position=Number(position);
            output+=word.substring(position-1,position);
        }
    }
    console.log(output);
}

solve([["filter", "UPPERCASE", 4, "AkIoRpSwOzFdT"],
    ["sort", "A", 3, "AOB"],
    ["sort", "A", 3, "FAILCL"],
    ["sort", "Z", 2, "OUTAGN"],
    ["filter", "UPPERCASE", 2, "01S345U7N"],
    ["rotate", 2, 2, "DAN"],
    ["get", 2, "PING"],
    ["get", 3, "?- 654"]]
);