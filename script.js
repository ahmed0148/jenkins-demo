let button=document.getElementById("myButton");
let title=document.getElementById("myTitle");

console.log(button.innerHTML);
button.addEventListener("click",function test() {
    title.style.color="red";
    
})