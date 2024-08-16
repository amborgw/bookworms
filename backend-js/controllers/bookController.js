const axios = require('axios');
const Book = require('../models/Book');

const fetchBookInfo = async (query) => {
  try {
    const { data } = await axios.get('https://www.googleapis.com/books/v1/volumes', {
      params: {
        q: query,
        key: process.env.GOOGLE_BOOKS_API_KEY
      }
    });

    return data.items.map(item => ({
      title: item.volumeInfo.title,
      author: item.volumeInfo.authors[0] || 'N/A',
      published_date: item.volumeInfo.publishedDate,
      description: item.volumeInfo.description,
      image: item.volumeInfo.imageLinks.thumbnail,
      link: item.volumeInfo.previewLink
    }));
  }
  catch (error) {
    console.error('Error fetching book info:', error);
    throw error;
  }
};

const searchBooks = async (req, res) => {
  try {
    const query = req.query.q; // get search query from request
    const books = await fetchBookInfo(query); // fetch book info
    res.json(books); // send book info as a response
  } catch (error) {
    console.error('Error searching books:', error);
    res.status(500).send('Server error');
  }
};

module.exports = { searchBooks }