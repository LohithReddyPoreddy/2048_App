import React, { useState, useEffect } from 'react';

function Grid() {
    const [gameBoard, setGameBoard] = useState([]);

    // Function to determine the tile color based on value
    function getTileColor(value) {
        if (value === 0) return 'bg-gray-300'; // Default color for empty tiles

        const power = Math.log2(value); // Calculate the power of 2
        const colors = [
            'bg-[#eee4da]', // 2^1 (2)
            'bg-[#ede0c8]', // 2^2 (4)
            'bg-[#f2b179]', // 2^3 (8)
            'bg-[#f59563]', // 2^4 (16)
            'bg-[#f67c5f]', // 2^5 (32)
            'bg-[#f65e3b]', // 2^6 (64)
            'bg-[#edcf72]', // 2^7 (128)
            'bg-[#edcc61]', // 2^8 (256)
            'bg-[#edc850]', // 2^9 (512)
            'bg-[#edc53f]', // 2^10 (1024)
            'bg-[#edc22e]', // 2^11 (2048)
        ];

        return colors[power - 1] || `bg-[hsl(${(power - 11) * 20},70%,50%)]`;
    }

    // Function to render the grid
    const renderGrid = () => {
        return gameBoard.map((row, rowIndex) => (
            <React.Fragment key={rowIndex}>
                {row.map((value, colIndex) => (
                    <div
                        key={`${rowIndex}-${colIndex}`}
                        className={`flex items-center justify-center h-20 w-20 text-lg font-bold rounded-md ${getTileColor(
                            value
                        )}`}
                    >
                        {value === 0 ? '' : value}
                    </div>
                ))}
            </React.Fragment>
        ));
    };

    // Function to start a new game
    async function startGame() {
        try {
            const response = await fetch('http://localhost:8080/api/game', {
                method: 'POST',
                headers: {
                    'content-type': 'application/json',
                },
                credentials: 'same-origin',
            });
            const data = await response.json();
            setGameBoard(data); // Set the new game board state
        } catch (err) {
            console.error(err);
        }
    }

    // useEffect to handle the start game button click event
    useEffect(() => {
        const newGameButton = document.getElementById('new-game');
        if (newGameButton) {
            newGameButton.addEventListener('click', startGame);
        }
        return () => {
            if (newGameButton) {
                newGameButton.removeEventListener('click', startGame);
            }
        };
    }, []);

    


    async function moveUp() {
        try{
            const response = await fetch('http://localhost:8080/api/game/moveUp',{
                method:'POST',
                headers:{
                    'content-type': 'application/json'
                },
                credentials: 'same-origin'
            });
            const data  = await response.json();
            setGameBoard(data);
        }
        catch (err){
            console.error(err);
        }
        
    }

    async function moveDown() {
        try{
            const response = await fetch('http://localhost:8080/api/game/moveDown',{
                method:'POST',
                headers:{
                    'content-type': 'application/json'
                },
                credentials: 'same-origin'
            });
            const data  = await response.json();
            setGameBoard(data);
        }
        catch (err){
            console.error(err);
        }
        
    }
    async function moveLeft() {
        try{
            const response = await fetch('http://localhost:8080/api/game/moveLeft',{
                method:'POST',
                headers:{
                    'content-type': 'application/json'
                },
                credentials: 'same-origin'
            });
            const data  = await response.json();
            setGameBoard(data);
        }
        catch (err){
            console.error(err);
        }
        
    }

    async function moveRight() {
        try{
            const response = await fetch('http://localhost:8080/api/game/moveRight',{
                method:'POST',
                headers:{
                    'content-type': 'application/json'
                },
                credentials: 'same-origin'
            });
            const data  = await response.json();
            setGameBoard(data);
        }
        catch (err){
            console.error(err);
        }
        
    }
    
    const handleKeyEvent = (event) => {
        if(event.key === 'ArrowUp'){
            moveUp();
        }
        else if(event.key === 'ArrowDown'){
            moveDown();
        }
        else if(event.key === 'ArrowLeft'){
            moveLeft();
        }
        else if(event.key === 'ArrowRight'){
            moveRight();
        }
    }
    

    useEffect(() => {
        window.addEventListener('keydown', handleKeyEvent)
        return() => window.removeEventListener('keydown', handleKeyEvent);
    },[] )
    

    return (
       
        <div className="game-container">
            <div id="game-board" className="grid grid-cols-4 gap-4 p-4 bg-gray-200 rounded-lg shadow-lg">
                {renderGrid()}
            </div>
        </div>
    );
}

export default Grid;
