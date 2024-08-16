const express = require('express');
const app = require('../server');

describe('GET /api/search', () => {
  it('should return book data with 200 OK', async () => {
    const searchQuery = 'Klara and the Sun';
    const response = await request(app)
      .get('/api/search')
      .query({ q: searchQuery });

    expect(response.status).toBe(200);
    expect(response.body).toEqual(
      expect.arrayContaining([
        expect.objectContaining({
          title: expect.stringMatching(new RegExp(searchQuery, 'i')), // case-insensitive
          authours: expect.stringMatching(new RegExp('Kazuo Ishiguro')), // at least one character
        })
      ])
    );
  });
});