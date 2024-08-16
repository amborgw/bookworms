const express = require('express');
const dotenv = require('dotenv');
const mongoose = require('mongoose');
const apiRoutes = require('./routes/apiRoutes');

// Load environment variables from .env file
dotenv.config();

// Initialize express app
const app = express();

app.use(express.json());
app.use('/api', apiRoutes); 

// Start the server
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});