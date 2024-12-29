import { useState } from 'react'

import './App.css'
import Header from './components/Header'
import Footer from './components/Footer'
import Grid from './components/Grid'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className='app-container'>
      <Header />
      <Grid />
      <Footer />
    </div>
  )
}

export default App
