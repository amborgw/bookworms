import React, { useEffect, useState } from 'react';

import { Image, StyleSheet, Platform, View, Pressable } from 'react-native';

import { HelloWave } from '@/components/HelloWave';
import ParallaxScrollView from '@/components/ParallaxScrollView';
import { ThemedText } from '@/components/ThemedText';
import { ThemedView } from '@/components/ThemedView';

export default function HomeScreen() {
  const books: string[] = [
    'Book1'
  ]
  const [currReads, setCurrReads] = useState<string[]>([])

  useEffect(() => {
    // Get the images for each book 
    setCurrReads(books)
  }, [books])

  return (
    <ThemedView
      style={{
        height: '100%',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center'
      }}
    >
      <View>
        <ThemedText
          type='defaultExtraBold'
          style={styles.text}
        >
          Current Reads
        </ThemedText>
          <div
            style={{
              width: 347,
              height: 524,
              borderRadius: '10px',
              backgroundColor: '#F8F9FA',
              padding: '32px',
              margin: '10px 0px'
            }}
            >
              {currReads.map((book, index) => (<ThemedText key={index}>{book}</ThemedText>))}
            <Pressable>
              <ThemedText>
                See more <span style={{ verticalAlign: '-1px' }}>{'\u2192'}</span>
              </ThemedText>
            </Pressable>
          </div>
        </View>
    </ThemedView>
  );
}

const styles = StyleSheet.create({
  titleContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 8,
  },
  stepContainer: {
    gap: 8,
    marginBottom: 8,
  },
  text: {
    marginTop: 27,
    paddingBottom: 10,
    alignSelf: 'baseline'
  }
});
