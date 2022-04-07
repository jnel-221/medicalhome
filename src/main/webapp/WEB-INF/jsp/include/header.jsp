<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./styles/style.css" />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://kit.fontawesome.com/ae53138fc4.js"
            crossorigin="anonymous"
    ></script>
    <style>
        .hero-image {
            background-image: linear-gradient(
                    rgba(0, 0, 0, 0.5),
                    rgba(0, 0, 0, 0.5)
            ),
            url("./images/karim-ben-van-mKk2nnZ1EQk-unsplash.jpg");
            height: 50%;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }

        .hero-text button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 10px 25px;
            color: black;
            background-color: #ddd;
            text-align: center;
            cursor: pointer;
        }

        .hero-text button:hover {
            background-color: #555;
            color: white;
        }
    </style>
</head>
<body>
<!-- navbar -->
<section id="header">
    <!-- removed navbar-light and bg-light fixed-top -->
    <nav class="navbar navbar-expand-lg fixed-top nav-style">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><!--img--></a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
            >
                <span><i class="fas fa-solid fa-bars"></i></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav mx-auto">
                    <a class="nav-link active" aria-current="page" href="index.html"
                    >Home</a
                    >
                    <a class="nav-link" href="./views/providers.html">Providers</a>
                    <a class="nav-link" href="./views/signup.html">Sign Up</a>
                    <a class="nav-link" href="./views/login.html">Log In</a>
                </div>
            </div>
        </div>
    </nav>
</section>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size: 50px">I ARE HERO</h1>
        <p>Big dang heroes</p>
        <button style="background-color: #f46d25">Hire me</button>
    </div>
</div>
<!-- end navbar -->