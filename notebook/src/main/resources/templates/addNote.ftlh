<!doctype html>

<#import "/spring.ftl" as spring/>

<html lang="ru">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="css/uikit.min.css" >

    <script src="js/uikit.min.js"></script>
    <script src="js/uikit-icons.min.js"></script>

    <title>All notes</title>

</head>
<body>

<div class="uk-background-primary uk-light uk-padding">

    <div align="center">
        <h2>Add Note</h2>
        <button class="uk-button uk-button-default" style="font-weight: normal; margin: -110px 0 0 1300px" onclick="document.location='/notes'">Main page</button>
    </div>

</div>

<div>
    <br><br>
</div>

<div style="width: 70%;">

    <form method="post" action="/addNote">

        <div class="uk-margin" style="padding-left: 450px">
            <input class="uk-input" type="text" placeholder="Title" name="title">
        </div>

        <div class="uk-margin" style="padding-left: 450px">
            <textarea class="uk-textarea" rows="5" placeholder="Text" name="body"></textarea>
        </div>

        <div align="center" style="padding-left: 500px">
            <input type="submit" class="uk-button uk-button-primary" value="Add note">
        </div>

    </form>

</div>

</body>
</html>