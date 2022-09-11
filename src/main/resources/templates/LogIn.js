import React from 'react'

fetch('http://localhost:9191/user/6')
        .then(res => res.json())
        .then(data => console.log(data))