<!doctype html>

<#import "/spring.ftl" as spring/>

<html lang="ru">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <link rel="stylesheet" href="/css/uikit.min.css" >

    <script src="/js/uikit.min.js"></script>
    <script src="/js/uikit-icons.min.js"></script>

    <title>All notes</title>

</head>
<body>

<script>
    var currentPage = 1;
</script>

<div>

    <div class="uk-column-1-2 uk-background-primary uk-light uk-padding">

        <div align="right" style="padding-left: 650px">
            <h2>NoteBook</h2>
        </div>

        <div align="right" class="uk-margin">

            <form class="uk-search uk-search-default" method="post" action="/search">
                <span uk-search-icon></span>
                <input class="uk-search-input" type="search" placeholder="Search..." name="title">
            </form>
        </div>

    </div>

</div>

<#list notes as note>

    <ul>

        <div>
            <br><br>

            <div align="center">

                <div class="uk-card uk-card-default uk-card-body uk-width-1-2@m">
                    <h3 class="uk-card-title">${note.title}</h3>
                    <p>${note.body}</p>
                </div>

            </div>

        </div>

    </ul>

</#list>


<div align="center">

    <br><br>

    <form method="post" action="/add">
        <input type="submit" class="uk-button uk-button-primary" value="Add note">
    </form>

</div>

<#if (size > 5)>


    <div>

        <br><br>

        <ul class="uk-pagination uk-flex-center" uk-margin>

            <li><a href="prev"><span uk-pagination-previous></span></a></li>

            <li><a href="1">1</a></li>

            <li><a href="2">2</a></li>

            <#if (size > 10) >
                <li><a href="3">3</a></li>

                <li class="uk-disabled"><span>...</span></li>

                <li><a href="end">end</a></li>

            </#if>

            <li><a href="?page=next"><span uk-pagination-next></span></a></li>
        </ul>

    </div>


</#if>

</body>
</html>