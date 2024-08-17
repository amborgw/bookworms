import React, {useState} from 'react';
import { TouchableOpacityComponent } from 'react-native';
import { Icon, Button } from 'react-native-elements';
import Search from './Search';

export default function BookBar() {
  const [visible, setVisibility] = useState(false);

  const handlePress = () => {
    setVisibility(!visible)
  }

  return (
    <div
      style={{
        display: 'flex',
        alignItems: 'center'
      }}
    >
      <Button
        icon={
            <Icon name='search' ></Icon>
        }
        onPress={handlePress}
        buttonStyle={{
          backgroundColor: 'transparent'
        }}
      >
          <TouchableOpacityComponent>
          </TouchableOpacityComponent>
      </Button>
      {visible && <Search />}
    </div>
  );
}