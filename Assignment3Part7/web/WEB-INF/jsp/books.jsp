<html>
<style>
.vl {
    border-left: 1px solid;
    height: 100%;
    margin-left: 100px;
    float:none;
}
.vl {
  margin-left: 200px;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
  <nav>
      <ul style="margin-top:2%;list-style-type:none;float:left">
      <li><a href="home.htm?action=home">Home</a></li></br>
        <li><a href="books.htm?action=books">Books</a></li></br>
        <li><a href="music.htm?action=music">Music</a></li></br>
        <li><a href="computer.htm?action=computers">Computers</a></li></br>
      </ul>
    </nav>
  <div class="vl">&nbsp;&nbsp;
Shop for Books
<hr>
<br>
<form method="post" action="home.htm">
  <input type="checkbox" name="cartVal" value="Java Servlet Programming[$29.95]">Java Servlet Programming[$29.95]<br><br>
  <input type="checkbox" name="cartVal" value="Oracke Database Programming[$48.95]">Oracke Database Programming[$48.95]<br><br>
  <input type="checkbox" name="cartVal" value="System Analysis and Design with UML[$14.95]">System Analysis and Design with UML[$14.95]<br><br>
  <input type="checkbox" name="cartVal" value="Object Oriented Software Engineering[$35.99]">Object Oriented Software Engineering[$35.99]<br><br>
  <input type="checkbox" name="cartVal" value="Java Web Services[$27.99]">Java Web Services[$27.99]<br><br>
  <input type="hidden" name="add" value="add">
  <input type="submit" value="Add to Cart">
</form>
</div>
</body>
</html>
