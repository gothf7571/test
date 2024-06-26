import React, { useEffect, useState } from 'react';

import './App.css';

function App() {
    const [message, setMessage] = useState('');

    useEffect(() => {
        fetch('/')
            .then(response => response.text())
            .then(data => setMessage(data));
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <h1></h1>
            </header>
        </div>
    );
}

export default App;