import React from 'react'


function Header() {
  return (
    <div className="relative shrink-0 transform-gpu will-change-[height, 56px] z-50">
    <div className="absolute left-0 right-0 bottom-0"></div>
    <header className="relative z-50">
        <div className="header-grid grid grid-cols-3 items-center transform-gpu px-2">
            <div className="col-start-1 flex items-center">
                <button className="hover:bg-slate-400 relative z-30 flex items-center gap-2 rounded-xl p-1 px-2 transition-colors duration-75 md:-mx-2">
                    <h1 className='text-5xl font-bold justify-center flex items-center' >2048</h1>
                </button>
            </div>
            <div className="col-start-2 flex justify-center gap-4">
                Score Board
            </div>
            <div className="col-start-3 flex justify-end gap-4">
                <button className="bg-slate-400 relative z-30 flex items-center gap-2 rounded-xl p-1 px-2 transition-colors duration-75 md:-mx-2">
                    <h1 className='text-xl font-bold justify-center flex items-center' id='new-game' >New Game</h1>
                </button>
            </div>
        </div>
    </header>
</div>

  )
}

export default Header