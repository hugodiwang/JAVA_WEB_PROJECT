// 在刷新页面的时候全局变量生成
var flag = true;
function showMenu(){
  var menu = document.getElementById("menuId");
  if(flag){
    menu.style.display="block";
    flag = false;
  }else{
    menu.style.display="none";
    flag = true;
  }
}
function closeMenu(){
  var menu = document.getElementById("menuId");
  menu.style.display="none";
  flag=true;
}
