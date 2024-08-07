import React from 'react';
import { TouchableOpacityComponent } from 'react-native';
import { SearchBar } from 'react-native-elements';
import { Icon, Button } from 'react-native-elements';

export default class Search extends React.Component {
  state = {
    search: '',
  };

  updateSearch = (search: string) => {
    this.setState({ search });
  };

  render() {
    const { search } = this.state;

    return (

			<SearchBar
				round={true}
				lightTheme={true}
				placeholder="Search book..."
				onChangeText={(text:string) => {this.updateSearch(text)}}
				value={search}
			/>

    );
  }
}