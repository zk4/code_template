import {fireEvent, render} from '@testing-library/react'
import Button, {ButtonProps, ButtonSize, ButtonType} from './button'

describe('tes Button component', () => {
  it('should render the correct default button', () => {
    const wrapper = render(<Button>Nice</Button>);
    const element = wrapper.getByText("Nice");
    expect(element).toBeInTheDocument();
    expect(element.tagName).toEqual('BUTTON');
    expect(element).toHaveClass('btn btn-default')
  })
  it('should call onClick funtion when btn is clicked', () => {
    const defaultProps  = {
      onClick: jest.fn()
    }
    const wrapper = render(<Button {...defaultProps}>Nice</Button>);
    const element = wrapper.getByText("Nice");
    fireEvent.click(element);
    expect(defaultProps.onClick).toHaveBeenCalled();
  })
  it('should render the correct component based on different props', () => {
    const testProps: ButtonProps = {
      btnType: ButtonType.Primary,
      size: ButtonSize.Large,
      className: 'klass'
    }
    const wrapper = render(<Button {...testProps}>Nice</Button>);
    const element = wrapper.getByText("Nice");
    expect(element).toBeInTheDocument();
    expect(element).toHaveClass('btn-primary btn-lg klass');

  })
  it('should render a link when btnType equals link and href is provided', () => {
    const wrapper = render(<Button btnType={ButtonType.Link} href="http://www.baidu.com">Nice</Button>);
    const element = wrapper.getByText("Nice");
    expect(element.tagName).toEqual('A');
    expect(element).toHaveClass('btn btn-link');
  })
  it('should render disabled button when disabled set to true', () => {
    const disabledProps  = {
      disabled: true,
      onClick: jest.fn()
    }
    const wrapper = render(<Button {...disabledProps}>Nice</Button>);
    const element = wrapper.getByText("Nice");
    expect(element).toBeTruthy();
    fireEvent.click(element);
    expect(disabledProps.onClick).not.toHaveBeenCalled();

  })
})
